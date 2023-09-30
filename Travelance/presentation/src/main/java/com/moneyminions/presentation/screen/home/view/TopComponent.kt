package com.moneyminions.presentation.screen.home.view

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.moneyminions.presentation.R
import com.moneyminions.presentation.common.CustomTextStyle.pretendardBold20
import com.moneyminions.presentation.navigation.Screen
import com.moneyminions.presentation.theme.CardLightGray
import com.moneyminions.presentation.viewmodel.home.HomeViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TopComponent(
    homeViewModel: HomeViewModel,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        if(homeViewModel.travelRoomInfo.value.isDone == "BEFORE") {
            Box (
                modifier = Modifier.fillMaxHeight().padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ){
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "backButton",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    },
                )
            }
        }
        
        TopLeftItem(
            homeViewModel,
            modifier = Modifier
                .fillMaxHeight(),
            navController
        )
    }
}

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TopLeftItem(
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Card(
        modifier = modifier.clickable(
            onClick = {
                navController.navigate(Screen.TravelDetail.route)
            },
        ),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(CardLightGray),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = homeViewModel.travelRoomInfo.value.travelName,
                style = pretendardBold20,
            )
            if(homeViewModel.isTravelStart.value) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.ic_right_arrow),
                    contentDescription = "move detail",
                )
            }
        }
    }
}

