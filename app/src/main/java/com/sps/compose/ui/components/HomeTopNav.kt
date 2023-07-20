package com.sps.compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sps.compose.R
import com.sps.compose.data.Prefs

@Composable
fun HomeTopNav(navController: NavHostController = rememberNavController(), title: String, onRefresh: ()->Unit = {}) {
    val menuExpanded = remember { mutableStateOf(false) }
    val context = LocalContext.current.applicationContext
//    val prefs = remember { mutableStateOf(Prefs(context)) }

    Surface(color = MaterialTheme.colorScheme.primary) {
        Box(modifier = Modifier.fillMaxWidth()) {
//            Surface(modifier = Modifier
//                .fillMaxWidth()
//                .height(180.dp), color = MaterialTheme.colorScheme.primary.copy(alpha = 1f)) {
//
//            }
            Image(
                painter = painterResource(id = R.drawable.world_map),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
//                .background(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(painter = painterResource(id = R.drawable.logox), contentDescription = null, Modifier.size(35.dp))
                    }

                    Text(
                        modifier = Modifier.weight(1f),
                        text = title,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleLarge,
                    )

//                    IconButton(onClick = {
//                        prefs.value.delete(Config.API_KEY)
//                        navController.navigate(Screen.Login.route)
//                    }) {
//                        Icon(
//                            imageVector = Icons.Default.Logout,
//                            contentDescription = null
//                        )
//                    }

                    IconButton(onClick = { onRefresh() }) {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = "Localized description"
                        )
                    }

                    IconButton(onClick = { menuExpanded.value = !menuExpanded.value }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "Localized description"
                        )
                        DropDownMenu(expanded = menuExpanded, navController)
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = (-10).dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                }
            }
        }
    }

}