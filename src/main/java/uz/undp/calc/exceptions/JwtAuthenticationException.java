package uz.undp.calc.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Authetication exception for JwtAppDemo application.
 *
 * @author Eugene Suleimanov
 * @version 1.0
 */

public class JwtAuthenticationException extends AuthenticationException {
    public JwtAuthenticationException(String message, Throwable t) {
        super(message, t);
    }

    public JwtAuthenticationException(String message) {
        super(message);
    }
}
