package com.patrimonio.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.patrimonio.model.User;

/**
 * Servlet Filter implementation class UserCheckFilter
 */
public class LoginCheckFilter extends AbstractFilter implements Filter {
	private static List<String> allowedURIs;

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		if (allowedURIs == null) {
			allowedURIs = new ArrayList<String>();
			allowedURIs.add(fConfig.getInitParameter("loginActionURI"));
			// allowedURIs.add("/patrimonioEJB/");
			allowedURIs.add("/patrimonioEJB/images/");
			allowedURIs.add("/patrimonioEJB/javax.faces.resource/");
			allowedURIs.add("/patrimonioEJB/javax.faces.resource/images/");
			allowedURIs.add("/patrimonioEJB/pages/");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/main.css.xhtml");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/theme.css.xhtml");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/primefaces.js.xhtml");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/primefaces.css.xhtml");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/jquery/jquery.js.xhtml");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/messages/messages.png.xhtml");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/images/default.png.xhtml");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/layout.css.xhtml");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/skeleton.css.xhtml");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/base.css.xhtml");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/app.js.xhtml");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/jquery-1.9.0.js.xhtml");
			// allowedURIs.add("/patrimonioEJB/javax.faces.resource/jquery-1.5.1.min.js.xhtml");

		}
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		if (session.isNew()) {
			doLogin(request, response, req);
			return;
		}

		User user = (User) session.getAttribute("user");

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

		chain.doFilter(request, response);
	}
}