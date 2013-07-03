package com.patrimonio.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import com.patrimonio.model.User;

public class NewFilterServlet extends AbstractFilter implements Filter{
	
	private static List<String> allowedURIs;
	private ServletContext context = null;

	public void init(FilterConfig config) throws ServletException {
		
		if (allowedURIs == null) {
			allowedURIs = new ArrayList<String>();
			allowedURIs.add(config.getInitParameter("loginActionURI"));
			// allowedURIs.add("/patrimonioEJB/");
			allowedURIs.add("/patrimonioEJB/images/");
			allowedURIs.add("/patrimonioEJB/javax.faces.resource/");
			allowedURIs.add("/patrimonioEJB/javax.faces.resource/images/");
			allowedURIs.add("/patrimonioEJB/pages/");
		// Obter o contexto para gravação de logs
		
			this.context = config.getServletContext();
		}
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 context.log("ENTROU NO FILTRO...");

		if (request instanceof HttpServletRequest) {
			// Receber o request
			HttpServletRequestWrapper req = new HttpServletRequestWrapper((HttpServletRequest) request);

			// Gravar logs
			 context.log("ID Anterior: " + (String) req.getSession().getId());

			if (req.getSession() != null && !req.getSession().isNew()) {
				 context.log("PASSO 1 - Recuperar a sessão atual");
				// Recuperar a sessão atual
				HttpSession oldSession = (HttpSession) req.getSession();

				 context.log("PASSO 2 - Salvar atributos da sessão atual");
				// Salvar os atributos da sessão atual
				Map<String, Object> oldAttribs = new HashMap<String, Object>();
				Enumeration names = oldSession.getAttributeNames();
				while (names.hasMoreElements()) {
					String name = (String) names.nextElement();
					oldAttribs.put(name, oldSession.getAttribute(name));
				}

				 context.log("PASSO 3 - Invalidar a sessão atual");
				// Invalidar a sessão atual
				req.getSession().invalidate();

				 context.log("PASSO 4 - Criar uma nova sessão");
				// Criar uma nova sessão
				HttpSession newSession = (HttpSession) req.getSession(true);
				 context.log("Nova Sessão: " + newSession.getId());

				 context.log("PASSO 5 - Copiar os dados da sessão antiga para a nova sessão");
				// Copiar os dados da sessão antiga para a nova sessão.
				for (String name : oldAttribs.keySet()) {
					newSession.setAttribute(name, oldAttribs.get(name));
					context.log(name);
				}
				
				User user = (User) newSession.getAttribute("user");

				if (user == null) {
					boolean isContain = false;
					for (String allow : allowedURIs) {
						if (req.getRequestURI().contains(allow)) {
							isContain = true;
							break;
						}
					}

					if (!isContain) {
						doLogin(request, response, req);
						return;
					}
				}

				// Salvar o novo request
				 context.log("PASSO 6 - Salvar o novo request...");
				req.setRequest(request);
			}
		}

		 context.log("SAIU DO FILTRO...");
		chain.doFilter(request, response);
	}
}
