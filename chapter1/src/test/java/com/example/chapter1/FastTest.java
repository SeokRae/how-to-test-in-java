package com.example.chapter1;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 메서드에서 사용
@Retention(RetentionPolicy.RUNTIME) // 런타임까지 유지
// 메타 어노테이션으로 사용
@Test
@Tag("fast") // 문자열이기 때문에 타입세이프하지 않음
public @interface FastTest {
}
