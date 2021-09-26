package com.example.chapter1.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class StudyTest {

    @DisplayName("테스트 환경 조건: (JRE) 체크 후 테스트")
    @Test
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
    void testCase1() {
        Study study = new Study(100);
        assertThat(study.getLimitCount()).isPositive();
    }

    @DisplayName("테스트 환경 조건: (시스템 OS) 체크 후 테스트")
    @Test
    @EnabledOnOs(OS.MAC)
    void testCase2() {
        Study study = new Study(100);
        assertThat(study.getLimitCount()).isPositive();
    }

    @DisplayName("테스트 환경 조건: (시스템 환경 변수) 체크 후 테스트")
    @Test
    void testCase3() {
        String logName = System.getenv("LOGNAME");
        assumingThat("seok".equalsIgnoreCase(logName), () -> {
            Study study = new Study(100);
            assertThat(study.getLimitCount()).isPositive();
        });
    }

    @DisplayName("테스트 환경 조건: (시스템 환경 변수2) 체크 후 테스트")
    @Test
    @EnabledIfEnvironmentVariable(named = "LOGNAME", matches = "seok")
    void testCase4() {
        Study study = new Study(100);
        assertThat(study.getLimitCount()).isPositive();
    }
}