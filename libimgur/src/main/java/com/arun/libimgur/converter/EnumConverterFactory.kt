package com.arun.libimgur.converter

import com.squareup.moshi.Json
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class EnumConverterFactory : Converter.Factory() { // extended from Converter.Factory
    override fun stringConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ):Converter<Enum<*>, String>? {
        return if(type is Class<*> && type.isEnum) {
            Converter<Enum<*>, String> { enum ->
                try {
                    enum.javaClass.getField(enum.name).getAnnotation(Json::class.java).name
                } catch (e: Exception) {
                    null
                }
            }
        }
        else {
            null
        }
    }
}