package br.com.zeus.reliablecargo.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AppExceptionHandler extends AbstractHandlerExceptionResolver {

    @Override
    protected ModelAndView doResolveException(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex) {
        return new ModelAndView();
//        try {
//            if (ex instanceof IllegalArgumentException) {
//                return handleIllegalArgument(
//                        (IllegalArgumentException) ex, response, handler);
//            }
//            ...
//        } catch (Exception handlerException) {
//            logger.warn("Handling of [" + ex.getClass().getName() + "]
//                    resulted in Exception", handlerException);
//        }
//        return null;
    }

//    private ModelAndView
//    handleIllegalArgument(IllegalArgumentException ex, HttpServletResponse response)
//            throws IOException {
//        response.sendError(HttpServletResponse.SC_CONFLICT);
//        String accept = request.getHeader(HttpHeaders.ACCEPT);
//        ...
//        return new ModelAndView();
//    }
}
