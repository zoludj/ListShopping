package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class Validator {


        public boolean validateName (String name) {
            if (name.length() < 3 || name.length() > 32) {
                return false;
            }
            return true;
        }

        public boolean validateDiscount(BigDecimal discount) {
            if (discount.intValue() > 100) {
                return false;
            }
            return true;
        }

        public boolean validatePrice(BigDecimal price) {
            if (price.intValue() < 0) {
                return false;
            }
            return true;

        }
    }

