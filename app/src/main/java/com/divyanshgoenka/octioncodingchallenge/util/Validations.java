package com.divyanshgoenka.octioncodingchallenge.util;

import java.util.Collection;

/**
 * Created by divyanshgoenka on 30/08/17.
 */

public class Validations {
    public static boolean isEmptyOrNull(Collection collection) {
        return collection==null||collection.size()<1;
    }
}
