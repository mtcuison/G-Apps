package org.rmj.g3appdriver;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.rmj.g3appdriver.etc.PasswordStrength;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PasswordStrengthTest {

    @Test
    public void test01TestStrength() throws Exception{
        assertEquals("Weak", PasswordStrength.getPasswordStrength(""));
    }
}
