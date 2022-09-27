package com.jisoo.unittest

import org.junit.Assert.*
import org.junit.Test
import com.google.common.truth.Truth.assertThat

class RegistrationUtilTest {

    @Test
    fun `empty username returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )

        assertThat(result).isFalse()
    }

    @Test
    fun `valid username and correctly repeated password returns true`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Jisoo",
            "123",
            "123"
        )

        assertThat(result).isTrue()
    }

    @Test
    fun `username alread exists returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "Peter",
            "123",
            "123"
        )

        assertThat(result).isFalse()
    }

    //empty password

    @Test
    fun `empty password returns false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "jisoo",
            "",
            ""
        )

        assertThat(result).isFalse()
    }
    //password was repeated incorrectly

    @Test
    fun `password was repeated returns incorrectly`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "jisoo",
            "123",
            "1234"
        )

        assertThat(result).isFalse()
    }

    //password contains less than 2 digits

    @Test
    fun `password contains less than 2 digits`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "jisoo",
            "dfdf1",
            "dfdf1"
        )

        assertThat(result).isFalse()
    }

}
