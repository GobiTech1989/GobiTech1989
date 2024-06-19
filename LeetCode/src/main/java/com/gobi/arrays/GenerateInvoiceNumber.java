package com.gobi.arrays;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.util.StringUtils;

public class GenerateInvoiceNumber {

	public static void main(String[] args) {
		
		
		
		String result = "242500004";
		System.out.println(generateInvoiceNumber(result));
		

	}
	
	public static synchronized String generateInvoiceNumber(String inputString) {
		LocalDate date = LocalDate.now();
		int year = date.getMonthValue() < 4 ? (date.getYear() - 1) : date.getYear();
		String fiscalYear = year%100 +""+ (year + 1)%100;
		long sequenceNumber = Long.valueOf(StringUtils.hasText(inputString) ? inputString.substring(4) : "0");
		AtomicLong seqNumber = new AtomicLong(sequenceNumber);
		long nextVal = seqNumber.incrementAndGet();
		String result = padLeftZeros(String.valueOf(nextVal), 6);
		return fiscalYear + result;
	}
	
	public static String padLeftZeros(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append('0');
	    }
	    sb.append(inputString);

	    return sb.toString();
	}

	
 
}