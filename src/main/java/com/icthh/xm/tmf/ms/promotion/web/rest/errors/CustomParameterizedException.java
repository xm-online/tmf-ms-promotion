package com.icthh.xm.tmf.ms.promotion.web.rest.errors;

import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Getter;

/**
 * Custom, parameterized exception, which can be translated on the client side.
 * For example:
 *
 * <pre>
 * throw new CustomParameterizedException(&quot;myCustomError&quot;, &quot;hello&quot;, &quot;world&quot;);
 * </pre>
 *
 * Can be translated with:
 *
 * <pre>
 * "error.myCustomError" :  "The server says {{param0}} to {{param1}}"
 * </pre>
 */
@Getter
public class CustomParameterizedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static final String PARAM = "param";

    private final URI type;

    private final Map<String, Object> parameters;

    public CustomParameterizedException(String message, String... params) {
        this(message, toParamMap(params));
    }

    public CustomParameterizedException(String message, Map<String, Object> paramMap) {
        super("Parameterized Exception");
        this.type = ErrorConstants.PARAMETERIZED_TYPE;
        this.parameters = toProblemParameters(message, paramMap);
    }

    public static Map<String, Object> toParamMap(String... params) {
        if (params == null || params.length == 0) {
            return Map.of();
        }
        return IntStream.range(0, params.length)
            .boxed()
            .collect(Collectors.toUnmodifiableMap(i -> PARAM + i, i -> params[i]));
    }

    public static Map<String, Object> toProblemParameters(String message, Map<String, Object> paramMap) {
        return Map.of(
            "message", message,
            "params", Map.copyOf(paramMap)
        );
    }
}
