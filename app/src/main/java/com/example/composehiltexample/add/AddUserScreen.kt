package com.example.composehiltexample.add

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.composehiltexample.add.AddUserViewModel

//@Preview//(showBackground = true)
@Composable
fun AddUserScreen(
    viewModel: AddUserViewModel = hiltViewModel(),
    onDismiss: () -> Unit
) {
    var inputUserId by remember { mutableStateOf("") }
    var inputName by remember { mutableStateOf("") }
    var inputComment by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.heightIn(min = 400.dp),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    ) {
        Box {
            Column(
                modifier = Modifier.padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text("UserID")
                TextField(
                    value = inputUserId,
                    onValueChange = { inputUserId = it },
//                label = { Text("ユーザーID") },
                    placeholder = { Text("12345") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text("Name")
                TextField(
                    value = inputName,
                    onValueChange = { inputName = it },
//                label = { Text("名前") },
                    placeholder = { Text("山田太郎") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text("Comment")
                TextField(
                    value = inputComment,
                    onValueChange = { inputComment = it },
//                label = { Text("コメント") },
                    placeholder = { Text("コメント") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    modifier = Modifier.fillMaxWidth()
                        .height(54.dp),
                    onClick = {

                    }
                ) {
                    Text("ユーザーを追加")
                }
            }
            IconButton(
                modifier = Modifier
                    .align(Alignment.TopEnd),
                onClick = {
                    onDismiss()
                }
            ) {
                Icon(Icons.Default.Close,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(44.dp)
                )
            }
        }
    }
}