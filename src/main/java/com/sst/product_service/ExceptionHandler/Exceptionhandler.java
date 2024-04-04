package com.sst.product_service.ExceptionHandler;

import com.sst.product_service.Exceptions.ProductnotFoundException;
import com.sst.product_service.dtos.Exceptiondto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exceptionhandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Exceptiondto> handleArithmeticException(){
        Exceptiondto dto = new Exceptiondto();
        dto.setMessage("Something went wrong");
        dto.setResolution("Arithmetic Exception");
        ResponseEntity<Exceptiondto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Exceptiondto> handleArrayIndexOutOfBoundException(){
        Exceptiondto dto = new Exceptiondto();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArrayIndexOutOfBoundException");
        ResponseEntity<Exceptiondto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exceptiondto> handleGeneralException(){
        Exceptiondto dto = new Exceptiondto();
        dto.setMessage("Something went wrong");
        dto.setResolution("Exception");
        ResponseEntity<Exceptiondto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
    @ExceptionHandler(ProductnotFoundException.class)
    public ResponseEntity<Exceptiondto> handleProductNotFoundException(ProductnotFoundException e){
        Exceptiondto dto = new Exceptiondto();
        dto.setMessage("Invalid product " + e.id +  " passed");
        dto.setResolution("ProductNotfoundException caught");
        ResponseEntity<Exceptiondto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }

}

