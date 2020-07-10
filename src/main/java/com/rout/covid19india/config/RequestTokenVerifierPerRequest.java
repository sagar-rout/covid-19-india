package com.rout.covid19india.config;

import com.rout.covid19india.service.BadRequestException;
import com.rout.covid19india.service.UnauthorizedException;
import com.rout.covid19india.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author Sagar Rout (sagar@rout.dev)
 * <p>
 * Verify every request and
 */
@Component
public class RequestTokenVerifierPerRequest extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestTokenVerifierPerRequest.class);

    private final UserService userService;

    public RequestTokenVerifierPerRequest(UserService userService) {
        this.userService = userService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        // don't validate

        final String requestURI = request.getRequestURI();
        final String method = request.getMethod();

        if (!(requestURI.equals("/users") && method.equals(HttpMethod.POST.name()))) {

            final String access_token = request.getHeader("access_token");

            if (Objects.isNull(access_token)) {
                LOGGER.error("ACCESS TOKEN is missing.");
                throw new BadRequestException("Access token is missing.");
            }

            if (access_token.isEmpty()) {
                LOGGER.error("ACCESS TOKEN is empty.");
                throw new UnauthorizedException("Access token is empty.");
            }

            if (!userService.isAccessTokenValid(access_token)) {
                throw new UnauthorizedException("Access token is invalid.");
            }
        }

        chain.doFilter(request, response);
    }
}
