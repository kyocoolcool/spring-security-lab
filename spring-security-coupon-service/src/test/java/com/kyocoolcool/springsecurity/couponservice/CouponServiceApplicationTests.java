package com.kyocoolcool.springsecurity.couponservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CouponServiceApplicationTests {
    @Autowired
    MockMvc mvc;

    @Test
    void testGetCouponWithoutAuth_Forbidden() throws Exception {
        mvc.perform(get("/couponapi/coupons/SUPERSALE")).andExpect(status().isForbidden());
    }

    @Test
    void testGetCouponWithoutAuth_Unauthorized() throws Exception {
        mvc.perform(get("/couponapi/coupons/SUPERSALE")).andExpect(status().isUnauthorized());
    }

    @Test
    //預設帶USER帳號
//    @WithMockUser(roles = {"ADMIN"})
    @WithUserDetails("doug@bailey.com")
    void testGetCouponWithoutAuth_Success() throws Exception {
        mvc.perform(get("/couponapi/coupons/SUPERSALE")).andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"code\":\"SUPERSALE\",\"discount\":10.000,\"expDate\":\"01/31/2021\"}"));
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testCreateCoupon_WithoutCSRF_Forbidden() throws Exception {
        mvc.perform(post("/couponapi/coupons")
                .content("{\"code\":\"SUPERSALE13\",\"discount\":130.000,\"expDate\":\"01/31/2021\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testCreateCoupon_WithCSRF_Success() throws Exception {
        mvc.perform(post("/couponapi/coupons")
                .content("{\"code\":\"SUPERSALE13\",\"discount\":130.000,\"expDate\":\"01/31/2021\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .with(csrf().asHeader()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = {"USER"})
    public void testCreateCoupon_WithCSRF_Forbidden() throws Exception {
        mvc.perform(post("/couponapi/coupons")
                .content("{\"code\":\"SUPERSALE13\",\"discount\":130.000,\"expDate\":\"01/31/2021\"}")
                .contentType(MediaType.APPLICATION_JSON)
                .with(csrf().asHeader()))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    public void testCORS() throws Exception {
        mvc.perform(options("/couponapi/coupons")
                .header("Access-Control-Request-Method", "POST")
                .header("Origin", "http://blog.kyocoolcool.com"))
                .andExpect(status().isOk())
                .andExpect(header().exists("Access-Control-Allow-Origin"))
                .andExpect(header().string("Access-Control-Allow-Origin", "*"))
                .andExpect(header().exists("Access-Control-Allow-Methods"))
                .andExpect(header().string("Access-Control-Allow-Methods", "POST"));

    }


}
