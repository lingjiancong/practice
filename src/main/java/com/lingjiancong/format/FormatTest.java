package com.lingjiancong.format;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import org.junit.Test;

/**
 * @author lingjiancong
 */
public class FormatTest {

    @Test
    public void phoneNumber() throws NumberParseException {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        String a = "", region = "";
        Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(a, region);

    }
}
