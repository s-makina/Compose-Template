package com.sps.compose.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Computer
import androidx.compose.material.icons.outlined.Wallpaper
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import com.sps.compose.R
import com.sps.compose.data.Prefs.authUser
import com.sps.compose.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNav(
    navController: NavHostController = rememberNavController(),
    pageTitle: String = "",
    backButton: Boolean = false,
) {
    val menuExpanded = remember { mutableStateOf(false) }
    val context = LocalContext.current.applicationContext
//    val prefs = remember { mutableStateOf(Prefs(context)) }

    SmallTopAppBar(
        title = { /*Text(pageTitle)*/ },
        navigationIcon = {
            if (backButton) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.logox),
                contentDescription = null,
                modifier = Modifier.width(100.dp)
            )
        },
        actions = {
//            IconButton(onClick = { isDarkTheme.value = !isDarkTheme.value }) {
//                val icon =
//                    if (isDarkTheme.value) Icons.Default.LightMode else Icons.Default.DarkMode
//                Icon(
//                    imageVector =
//                    icon,
//                    contentDescription = null
//                )
//            }

            IconButton(onClick = {
//                prefs.value.delete(API_KEY)
//                navController.navigate(Screen.Login.route)
            }) {
                Icon(
                    imageVector = Icons.Default.Logout,
                    contentDescription = null
                )
            }
//            IconButton(onClick = { menuExpanded.value = !menuExpanded.value }) {
//                Icon(
//                    imageVector = Icons.Filled.MoreVert,
//                    contentDescription = "Localized description"
//                )
//                DropDownMenu(expanded = menuExpanded, navController)
//            }
        }
    )

}

@Composable
fun DropDownMenu(expanded: MutableState<Boolean>, navController: NavHostController) {

    Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
        DropdownMenu(expanded = expanded.value, onDismissRequest = { expanded.value = false }) {
//            DropdownMenuItem(
//                text = { Text(text = Screen.Home.pageTitle) },
//                onClick = { navController.navigate(Screen.Home.route) },
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.QrCodeScanner,
//                        contentDescription = ""
//                    )
//                })
//
//            DropdownMenuItem(
//                text = { Text(text = Screen.MyProfileDash.pageTitle) },
//                onClick = { navController.navigate(Screen.MyProfileDash.route) },
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.Dashboard,
//                        contentDescription = ""
//                    )
//                })
//
//            DropdownMenuItem(
//                text = { Text(text = Screen.AddStaff.pageTitle) },
//                onClick = { navController.navigate(Screen.AddStaff.route) },
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.Person,
//                        contentDescription = ""
//                    )
//                })
//
//            DropdownMenuItem(
//                text = { Text(text = "Users") },
//                onClick = { navController.navigate(Screen.StaffList.route) },
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.Person,
//                        contentDescription = ""
//                    )
//                })
//
//            DropdownMenuItem(
//                text = { Text(text = "Invoices") },
//                onClick = { navController.navigate(Screen.InvoicePage.route)/*TODO*/ },
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Outlined.Wallpaper,
//                        contentDescription = ""
//                    )
//                })
            val context = LocalContext.current.applicationContext
            DropdownMenuItem(
                text = { Text(text = "Logout") },
                onClick = {
//                    val prefs = Prefs(context)
//                    prefs.delete(API_KEY)
//                    navController.navigate(Screen.Login.route)
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Computer,
                        contentDescription = ""
                    )
                })
        }
    }

}

@Composable
fun MainTopNav(navController: NavHostController = rememberNavController(), time: String, onRefresh: ()-> Unit = {}) {
    val menuExpanded = remember { mutableStateOf(false) }

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
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
//                .background(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(authUser.value?.image)
                            .size(180)
                            .crossfade(true)
                            .build(),
                        error = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp, top = 4.dp)
                            .size(40.dp)
                            .clip(shape = CircleShape)
                    )

                    Column(modifier = Modifier.weight(1f)) { }

                    IconButton(onClick = { onRefresh() }) {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = "Localized description"
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
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
                        .offset(y = (-20).dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = time,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.displaySmall
                    )
//                    Text(
//                        text = authUser.value?.staff?.lastCheckInOut() ?: "",
//                        style = MaterialTheme.typography.bodyMedium,
////                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
//                    )
                }
            }
        }
    }

}


@Composable
fun SearchTopNav(navController: NavHostController = rememberNavController(), title: String) {
    val menuExpanded = remember { mutableStateOf(false) }

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
                    .height(100.dp),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
//                .background(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.salva),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .padding(start = 8.dp, end = 8.dp, top = 4.dp)
//                            .size(40.dp)
//                            .clip(shape = CircleShape)
//                    )
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(authUser.value?.image)
                            .size(180)
                            .crossfade(true)
                            .build(),
                        error = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp, top = 4.dp)
                            .size(40.dp)
                            .clip(shape = CircleShape)
                    )

                    Text(
                        modifier = Modifier.weight(1f),
                        text = title,
                        maxLines = 1,
                        textAlign = TextAlign.Center,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.titleLarge,
                    )

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
