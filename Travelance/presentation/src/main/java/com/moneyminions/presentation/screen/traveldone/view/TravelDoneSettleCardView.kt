package com.moneyminions.presentation.screen.traveldone.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.moneyminions.domain.model.traveldetail.TravelPaymentDto
import com.moneyminions.presentation.common.CustomTextStyle
import com.moneyminions.presentation.theme.CardLightGray
import com.moneyminions.presentation.theme.DarkerGray

@Composable
fun TravelDoneSettleCardView(
    modifier: Modifier = Modifier,
    travelPaymentList: List<TravelPaymentDto>,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(CardLightGray),
    ) {
        LazyColumn(
            modifier = modifier.padding(horizontal = 16.dp, vertical = 12.dp),
        ) {
            if (travelPaymentList.isEmpty()) {
                item {
                    Row {
                        Text(
                            text = "공금 내역이 없습니다",
                            color = DarkerGray,
                            style = CustomTextStyle.pretendardBold14,
                            modifier = modifier.padding(vertical = 16.dp),
                        )
                    }
                }
            }
            itemsIndexed(travelPaymentList) { index, item ->
                TravelDoneSettleContentView(
                    modifier = modifier,
                    travelMoneyPayment = item,
                )
            }
        }
    }
}
