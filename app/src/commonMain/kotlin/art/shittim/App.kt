package art.shittim

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.darkColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme(
        colors = darkColors()
    ) {
        var token by remember { mutableStateOf("") }
        var content by remember { mutableStateOf("") }
        var contrib by remember { mutableStateOf("") }
        var time by remember { mutableStateOf("") }
        var sensitive by remember { mutableStateOf(false) }
        var unsure by remember { mutableStateOf(false) }
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Surface(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Column(
                    Modifier.fillMaxSize().padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        value = token,
                        onValueChange = { token = it },
                        label = { Text("Token") },
                    )

                    Divider()

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        value = content,
                        onValueChange = { content = it },
                        label = { Text("Content") },
                    )

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        value = contrib,
                        onValueChange = { contrib = it },
                        label = { Text("Contributor") },
                    )

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        value = time,
                        onValueChange = { time = it },
                        label = { Text("Time") },
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Sensitive:")
                        Checkbox(
                            checked = sensitive,
                            onCheckedChange = { sensitive = it },
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text("Unsure:")
                        Checkbox(
                            checked = unsure,
                            onCheckedChange = { unsure = it },
                        )
                    }
                    Button(
                        onClick = {
                            submit(
                                RequestArticleLine(
                                    time,
                                    contrib,
                                    content,
                                    unsure,
                                    sensitive
                                ),
                                token
                            )
                            
                            content = ""
                            time = ""
                        }
                    ) {
                        Text("Submit")
                    }
                }
            }
        }
    }
}
