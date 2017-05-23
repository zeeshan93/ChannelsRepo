package com.compassites.channels.utils;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {

  @Autowired
  private MessageSource messageSource;

  public String getMessge(String msg) {
    Locale locale = LocaleContextHolder.getLocale();
    String message = messageSource.getMessage(msg, null, locale);
    return message;
  }

}
