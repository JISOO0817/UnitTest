package com.jisoo.unittest

import android.app.Application
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {

    private lateinit var resourceComparer:ResourceComparer

    /**
     * 테스트 케이스가 실행되기전에 실행되므로
     * 초기화할때 사용 가능
     *
     * */
    @Before
    fun setup() {
        resourceComparer = ResourceComparer()
    }

    /**
     * 이전에 만든 객체 파괴 (ex room database...)
     * */
    @After
    fun teardown() {

    }

    @Test
    fun stringResourceSameAsGivenString_returnTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context,R.string.app_name,"UnitTest")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGivenString_returnFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context,R.string.app_name,"Hello")
        assertThat(result).isFalse()
    }

}