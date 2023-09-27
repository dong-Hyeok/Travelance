package com.moneyminions.data.service

import com.moneyminions.data.model.common.response.CommonResponse
import com.moneyminions.data.model.login.request.AuthenticationAccountRequest
import com.moneyminions.data.model.login.request.LoginRequest
import com.moneyminions.data.model.login.request.MemberInfoRequest
import com.moneyminions.data.model.login.response.AccountResponse
import com.moneyminions.data.model.login.response.AuthenticationAccountResponse
import com.moneyminions.data.model.login.response.CardResponse
import com.moneyminions.data.model.login.response.JoinResponse
import com.moneyminions.data.model.login.response.LoginResponse
import com.moneyminions.data.model.traveldetail.response.TravelDetailInfoResponse
import com.moneyminions.data.model.traveldetail.response.TravelDetailMyPaymentResponse
import com.moneyminions.data.model.travellist.request.CreateTravelRoomRequest
import com.moneyminions.data.model.travellist.response.TravelRoomResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Query

interface BusinessService {

    /**
     * 로그인 API
     */
    @POST("api/oauth/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    /**
     * 1원 이체 요청
     */
    @POST("account/1request")
    suspend fun postAuthenticationAccount(@Body authenticationAccountRequest: AuthenticationAccountRequest): AuthenticationAccountResponse

    /**
     * 1원 이체 확인
     */
    @POST("account/1response")
    suspend fun confirmAuthenticationAccount(@Body authenticationAccountRequest: AuthenticationAccountRequest): CommonResponse

    /**
     * 내 전체 계좌 조회
     */
    @POST("account/allaccount")
    suspend fun getAccountList(): List<AccountResponse>

    /**
     * 내 전체 카드 조회
     */
    @POST("card/allcard")
    suspend fun getCardList(): List<CardResponse>

    /**
     * 회원 등록
     */
    @PATCH("member/additional")
    suspend fun join(@Body memberInfoRequest: MemberInfoRequest): JoinResponse

    /**
     * 여행방 만들기 API
     */
    @POST("travel/room")
    suspend fun createTravelRoom(@Body createTravelRoomRequest: CreateTravelRoomRequest): String

    /**
     * 여행 목록 요청 API
     */
    @GET("travel/room")
    suspend fun travelList(): MutableList<TravelRoomResponse>

    /**
     * 개인 결제 금액 요청
     */
    @GET("travel/payment/alone")
    suspend fun getMyPaymentList(@Query("email") email: String): List<TravelDetailMyPaymentResponse>

    /**
     * 여행 상세 요청
     */
    @GET("travel/payment/with")
    suspend fun getTravelDetailInfo(@Query("email") email: String): TravelDetailInfoResponse
}
