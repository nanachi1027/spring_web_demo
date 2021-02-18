package org.example.api;

import org.example.model.response.OperationResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Mae
 * @Date: 2021/2/18 3:59 上午
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public OperationResponse handleBaseException(DataIntegrityViolationException e) {
        OperationResponse resp = new OperationResponse();
        resp.setOperationStatus(OperationResponse.ResponseStatusEnum.ERROR);
        resp.setOperationMessage(e.getRootCause().getMessage());
        return resp;
    }
}
