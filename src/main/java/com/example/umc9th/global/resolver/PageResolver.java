package com.example.umc9th.global.resolver;

import com.example.umc9th.global.annotation.PageValidate;
import com.example.umc9th.global.apiPayload.exception.PageException;
import com.example.umc9th.global.apiPayload.code.PageErrorCode;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.*;

@Component
public class PageResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PageValidate.class)
                && parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) {

        String pageStr = webRequest.getParameter("page");

        if (pageStr == null)
            throw new PageException(PageErrorCode.PAGE_REQUIRED);

        int page = Integer.parseInt(pageStr);

        if (page <= 0)
            throw new PageException(PageErrorCode.INVALID_PAGE);

        return page - 1;  // JPA paging은 0부터 시작
    }
}
