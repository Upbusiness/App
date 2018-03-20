/*
 * Copyright (c) 2010, Oracle.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  * Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT 
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package action;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import org.jdesktop.beansbinding.Converter;

/**
 * <code>Integer</code> to <code>String</code> converter
 * that returns zero when the argument cannot be parsed.
 * 
 * @author Jiri Vagner, Jan Stola
 */
public class DecimalConverter extends Converter<Double, String> {

    private static DecimalFormat v = new DecimalFormat("0.00");
    @Override
    public String convertForward(Double value) {
       
       if(value >= 0){
           
       BigDecimal bd = new BigDecimal(value);
       bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
       
        System.out.println(">>>>>>>>>Acionou Forward Decimal Converter - Valor"+String.valueOf(bd.doubleValue()));
        return v.format(bd).replace(".", ",");
        
       }else{
           
         return null; 
           
           
       }
        
        
    }

    @Override
    public Double convertReverse(String value) {
       
       if(!value.isEmpty()){
           
       BigDecimal bd = new BigDecimal(value.replace(",", "."));
       bd = bd.setScale(2,BigDecimal.ROUND_HALF_UP);
       
       System.out.println(">>>>>>>>Acionou Reverse Decimal Converter - Valor"+bd.doubleValue()); 
       return  Double.valueOf(v.format(bd.doubleValue()).replace(",", "."));
       
        }else{
           
         return 0.0; 
           
           
       }
        
    }
}