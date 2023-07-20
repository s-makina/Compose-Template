package com.sps.compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
//
//@Composable
//fun ProfileTopNav(navController: NavHostController = rememberNavController(), staff: Staff?) {
//    val menuExpanded = remember { mutableStateOf(false) }
//
//    Surface(color = MaterialTheme.colorScheme.primary) {
//        Box(modifier = Modifier.fillMaxWidth()) {
//            Image(
//                painter = painterResource(id = R.drawable.world_map),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(170.dp),
//                contentScale = ContentScale.Crop
//            )
//
//
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(170.dp)
////                .background(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
////                    Image(
////                        painter = painterResource(id = R.drawable.salva),
////                        contentDescription = null,
////                        modifier = Modifier
////                            .padding(start = 8.dp, end = 8.dp, top = 4.dp)
////                            .size(40.dp)
////                            .clip(shape = CircleShape)
////                    )
//                    IconButton(onClick = { navController.popBackStack() }) {
//                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
//                    }
//
//                    Text(
//                        modifier = Modifier.weight(1f),
//                        text = "",
//                        maxLines = 1,
//                        textAlign = TextAlign.Center,
//                        overflow = TextOverflow.Ellipsis,
//                        style = MaterialTheme.typography.titleLarge,
//                    )
//
//                    IconButton(onClick = { menuExpanded.value = !menuExpanded.value }) {
//                        Icon(
//                            imageVector = Icons.Filled.MoreVert,
//                            contentDescription = "Localized description"
//                        )
//                        DropDownMenu(expanded = menuExpanded, navController)
//                    }
//                }
//
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .offset(y = (-18).dp),
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//
////                    Image(
////                        painter = painterResource(id = R.drawable.salva),
////                        contentDescription = null,
////                        modifier = Modifier
////                            .padding(start = 8.dp, end = 8.dp, top = 4.dp)
////                            .size(60.dp)
////                            .clip(shape = CircleShape)
////                            .border(
////                                width = 1.dp,
////                                color = MaterialTheme.colorScheme.onPrimary,
////                                shape = CircleShape
////                            ),
////                        contentScale = ContentScale.Crop
////                    )
////
//                    AsyncImage(
//                        model = ImageRequest.Builder(LocalContext.current)
//                            .data(staff?.image)
//                            .size(120)
//                            .crossfade(true)
//                            .build(),
//                        error = painterResource(id = R.drawable.profile),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .size(60.dp)
//                            .padding()
//                            .clip(CircleShape)
//                            .border(
//                                width = 1.dp,
//                                color = MaterialTheme.colorScheme.onPrimary,
//                                shape = CircleShape
//                            ),
//                        contentScale = ContentScale.Crop,
//                    )
//
//                    Text(text = staff?.name ?: "", style = MaterialTheme.typography.titleMedium)
////                    Text(text = staff?.position ?: "", style = MaterialTheme.typography.bodySmall)
//                }
//            }
//        }
//    }
//
//}