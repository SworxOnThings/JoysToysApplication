package com.JoysToysApplication.JoysToysApplication.Config;

import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

public class Constants {
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
    public static final String SIGNING_KEY = "cHVzc3kxMjNwdXNzeTEyM3B1c3N5MTIzcHVzc3kxMjNwdXNzeTEyM3B1c3N5MTIzcHVzc3kxMjNwdXNzeTEyM3B1c3N5MTIzcHVzc3kxMjNwdXNzeTEyM3B1c3N5MTIzcHVzc3kxMjNwdXNzeTEyM3B1c3N5MTIzcHVzc3kxMjNwdXNzeTEyM3B1c3N5MTIzcHVzc3kxMjNwdXNzeTEyM3B1c3N5MTIzcHVzc3kxMjNwdXNzeTEyM3B1c3N5MTIzcHVzc3kxMjNwdXNzeTEyM3B1c3N5MTIzcHVzc3kxMjNwdXNzeTEyM3B1c3N5MTIzcHVzc3kxMjNwdXNzeTEyM3B1c3N5MTIzcHVzc3kxMjM=";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

}
