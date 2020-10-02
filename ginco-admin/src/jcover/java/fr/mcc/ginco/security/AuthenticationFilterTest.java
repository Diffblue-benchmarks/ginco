package fr.mcc.ginco.security;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

/**
 * Unit tests for fr.mcc.ginco.security.AuthenticationFilter
 *
 * @author Diffblue Cover
 */

class AuthenticationFilterTest {

	@Test
	void factory() throws java.io.IOException, javax.servlet.ServletException, org.springframework.security.core.AuthenticationException, org.springframework.context.NoSuchMessageException, org.springframework.security.web.authentication.session.SessionAuthenticationException, IllegalStateException, IllegalArgumentException, java.net.MalformedURLException {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter();
		LockoutService lockoutService = new LockoutService();
		authenticationFilter.setLockoutService(lockoutService);
		authenticationFilter.setPasswordParameter("data");
		authenticationFilter.setPostOnly(false);
		authenticationFilter.setUsernameParameter("data");
		authenticationFilter.setAllowSessionCreation(false);
		ApplicationEventPublisher eventPublisher =
			 mock(ApplicationEventPublisher.class);
		authenticationFilter.setApplicationEventPublisher(eventPublisher);
		@SuppressWarnings("unchecked")
		AuthenticationDetailsSource<HttpServletRequest, Object> authenticationDetailsSource =
			 mock(AuthenticationDetailsSource.class);
		authenticationFilter.setAuthenticationDetailsSource(authenticationDetailsSource);
		AuthenticationFailureHandler failureHandler =
			 mock(AuthenticationFailureHandler.class);
		authenticationFilter.setAuthenticationFailureHandler(failureHandler);
		AuthenticationManager authenticationManager =
			 mock(AuthenticationManager.class);
		authenticationFilter.setAuthenticationManager(authenticationManager);
		AuthenticationSuccessHandler successHandler =
			 mock(AuthenticationSuccessHandler.class);
		authenticationFilter.setAuthenticationSuccessHandler(successHandler);
		authenticationFilter.setContinueChainBeforeSuccessfulAuthentication(false);
		authenticationFilter.setFilterProcessesUrl("/bin/bash");
		MessageSource messageSource = mock(MessageSource.class);
		authenticationFilter.setMessageSource(messageSource);
		RememberMeServices rememberMeServices = mock(RememberMeServices.class);
		authenticationFilter.setRememberMeServices(rememberMeServices);
		SessionAuthenticationStrategy sessionStrategy =
			 mock(SessionAuthenticationStrategy.class);
		authenticationFilter.setSessionAuthenticationStrategy(sessionStrategy);
		authenticationFilter.setBeanName("data.txt");
		Environment environment = mock(Environment.class);
		authenticationFilter.setEnvironment(environment);
		ServletContext servletContext = mock(ServletContext.class);
		authenticationFilter.setServletContext(servletContext);
		assertThat(authenticationFilter.getLockoutService(), sameInstance(lockoutService));
		assertThat(authenticationFilter.getPasswordParameter(), is("data"));
		assertThat(authenticationFilter.getUsernameParameter(), is("data"));
		assertThat(authenticationFilter.getFilterProcessesUrl(), is("/bin/bash"));
		assertThat(authenticationFilter.getRememberMeServices(), sameInstance(rememberMeServices));
		assertThat(authenticationFilter.getFilterConfig(), is(nullValue()));
	}

	@Test
	void attemptAuthentication() throws java.io.IOException, javax.servlet.ServletException, org.springframework.security.core.AuthenticationException, org.springframework.context.NoSuchMessageException, org.springframework.security.web.authentication.session.SessionAuthenticationException, IllegalStateException, IllegalArgumentException, java.net.MalformedURLException, java.io.UnsupportedEncodingException {

		// arrange
		AuthenticationFilter authenticationFilter = new AuthenticationFilter();
		authenticationFilter.setLockoutService(new LockoutService());
		authenticationFilter.setPasswordParameter("data");
		authenticationFilter.setPostOnly(false);
		authenticationFilter.setUsernameParameter("data");
		authenticationFilter.setAllowSessionCreation(false);
		ApplicationEventPublisher eventPublisher =
			 mock(ApplicationEventPublisher.class);
		authenticationFilter.setApplicationEventPublisher(eventPublisher);
		@SuppressWarnings("unchecked")
		AuthenticationDetailsSource<HttpServletRequest, Object> authenticationDetailsSource =
			 mock(AuthenticationDetailsSource.class);
		when(authenticationDetailsSource.buildDetails(Mockito.<HttpServletRequest>any()))
			.thenReturn(new Object());
		authenticationFilter.setAuthenticationDetailsSource(authenticationDetailsSource);
		AuthenticationFailureHandler failureHandler =
			 mock(AuthenticationFailureHandler.class);
		authenticationFilter.setAuthenticationFailureHandler(failureHandler);
		AuthenticationManager authenticationManager =
			 mock(AuthenticationManager.class);
		when(authenticationManager.authenticate(Mockito.<Authentication>any()))
			.thenReturn(new TestingAuthenticationToken("password", "password"));
		authenticationFilter.setAuthenticationManager(authenticationManager);
		AuthenticationSuccessHandler successHandler =
			 mock(AuthenticationSuccessHandler.class);
		authenticationFilter.setAuthenticationSuccessHandler(successHandler);
		authenticationFilter.setContinueChainBeforeSuccessfulAuthentication(false);
		authenticationFilter.setFilterProcessesUrl("/bin/bash");
		MessageSource messageSource = mock(MessageSource.class);
		authenticationFilter.setMessageSource(messageSource);
		RememberMeServices rememberMeServices = mock(RememberMeServices.class);
		authenticationFilter.setRememberMeServices(rememberMeServices);
		SessionAuthenticationStrategy sessionStrategy =
			 mock(SessionAuthenticationStrategy.class);
		authenticationFilter.setSessionAuthenticationStrategy(sessionStrategy);
		authenticationFilter.setBeanName("data.txt");
		Environment environment = mock(Environment.class);
		authenticationFilter.setEnvironment(environment);
		ServletContext servletContext = mock(ServletContext.class);
		authenticationFilter.setServletContext(servletContext);
		HttpServletRequest request = mock(HttpServletRequest.class);
		when(request.getParameter(Mockito.<String>any()))
			.thenReturn("/some/path.html")
			.thenReturn("/some/path.html")
			.thenReturn("Locked ");

		// act
		Authentication result =
			 authenticationFilter.attemptAuthentication(request, new MockHttpServletResponse());

		// assert
		assertThat(result.getAuthorities(), empty());
		assertThat((String) result.getCredentials(), is("password"));
		assertThat(result.getDetails(), is(nullValue()));
		assertThat((String) result.getPrincipal(), is("password"));
		assertThat(result.isAuthenticated(), is(false));
	}
}
