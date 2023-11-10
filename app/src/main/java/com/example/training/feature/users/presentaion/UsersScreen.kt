import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.training.core.model.User
import com.example.training.feature.users.presentaion.viewmodel.ApiState
import com.example.training.feature.users.presentaion.viewmodel.UserViewModel

@Composable
fun UsersScreen(navController: NavController, viewModel: UserViewModel) {
    val usersState by viewModel.users.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchUsers()
    }

    when (usersState) {
        is ApiState.Loading -> {
            // Show loading indicator
            CircularProgressIndicator()
        }
        is ApiState.Success<*> -> {
            val users = (usersState as ApiState.Success<List<User>>).data
            // Display the fetched data using Jetpack Compose components
            Column {
                Text("User List:")
                LazyColumn {
                    items(users) { user ->
                        Text(user.name)
                    }
                }
            }
        }
        is ApiState.Error -> {
            val error = (usersState as ApiState.Error).message
            // Show error message
            Text(
                text = "Failed to fetch data: $error",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SecondScreenPreview() {
//    Surface(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        SecondScreen(navController = rememberNavController(), )
//    }
//}