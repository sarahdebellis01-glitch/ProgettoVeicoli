package com.betacom.jpa.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import exceptions.AcademyException;



public class Utilities {

	private final static String PATTERN_DATE = "d/M/yyyy HH:mm:ss:SSSS";
	private final static String PATTERN_DATE_1 = "dd/MM/yyyy";
	//transformare data in formato stringa
	
	public static String dateToString(LocalDateTime myDate) {
		return dateToString(PATTERN_DATE, myDate);
	}
	public static String dateToString(String pattern, LocalDateTime myDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN);
		return myDate.format(formatter);
	}
		public static String dateToString(String pattern, LocalDate myDate) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN);
			return myDate.format(formatter);
		} 
		public static LocalDate dateToLocalDate(Object value) {

		    if (value == null) return null;

		    if (value instanceof java.sql.Date) {
		        return ((java.sql.Date) value).toLocalDate();
		    }
			return null;
		}
			public static LocalDate stringToDate( String myDate) throws AcademyException{
				LocalDate r = null;
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_DATE_1, Locale.ITALIAN);
					return LocalDate.parse(myDate, formatter);
				}catch(DateTimeParseException e) {
					throw new AcademyException("Formato della data invalido: "+ myDate + "formato prevsito: "+ PATTERN_DATE_1);
				}
				
			}
	
}
