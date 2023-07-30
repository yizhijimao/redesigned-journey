package com.qf.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Function;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T>  {



    private int code;
    private String msg;
    private T data;


}
