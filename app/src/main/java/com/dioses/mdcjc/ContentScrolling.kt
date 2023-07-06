package com.dioses.mdcjc

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.dioses.mdcjc.ui.theme.MDCJCTheme


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContentPreview() {
    MDCJCTheme {
        Content()
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun Content(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Column {
                var urlValue by remember { mutableStateOf("") }

                GlideImage(
                    model = urlValue,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.card_img_cover_height))
                        .background(colorResource(id = R.color.teal_200)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = stringResource(
                        id = R.string.card_title
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.common_padding_default)),
                    style = MaterialTheme.typography.headlineMedium
                )

                OutlinedTextField(value = urlValue,
                    onValueChange = { urlValue = it },
                    label = { Text(text = stringResource(id = R.string.card_input_url)) },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = dimensionResource(id = R.dimen.common_padding_default),
                            start = dimensionResource(id = R.dimen.common_padding_default),
                            end = dimensionResource(id = R.dimen.common_padding_default)
                        ),
                    trailingIcon = {
                        if (urlValue.isNotEmpty()) {
                            Icon(imageVector = Icons.Filled.Clear,
                                contentDescription = "Limpiar",
                                modifier = Modifier.clickable { urlValue = "" })
                        }
                    })
                Text(
                    text = stringResource(id = R.string.card_required),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
                    modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.card_padding_default),
                        top = dimensionResource(
                            id = R.dimen.card_padding_micro
                        )
                    )
                )
                var isCheckboxChecked by remember { mutableStateOf(false) }
                var passwordValue by remember { mutableStateOf("") }
                var isPasswordVisible by remember { mutableStateOf(false) }

                OutlinedTextField(value = passwordValue,
                    onValueChange = { passwordValue = it },
                    label = { Text(text = stringResource(id = R.string.card_password)) },
                    singleLine = true,
                    enabled = isCheckboxChecked,
                    visualTransformation = if (isPasswordVisible) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = dimensionResource(id = R.dimen.common_padding_default),
                            start = dimensionResource(id = R.dimen.common_padding_default),
                            end = dimensionResource(id = R.dimen.common_padding_default)
                        ),
                    trailingIcon = {
                        Icon(painter = if (isPasswordVisible) painterResource(id = R.drawable.ic_visibility_off)
                        else painterResource(id = R.drawable.ic_visibility),
                            contentDescription = null,
                            modifier = Modifier.clickable {
                                isPasswordVisible = !isPasswordVisible
                            })
                    })
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = isCheckboxChecked,
                        onCheckedChange = { isCheckboxChecked = it })
                    Text(text = stringResource(id = R.string.card_enable_pass))

                    Spacer(modifier = Modifier.weight(1f))

                    Text(text = stringResource(id = R.string.card_hide_fab))
                    var isSwitchChecked by remember { mutableStateOf(true) }

                    Switch(
                        checked = isSwitchChecked,
                        onCheckedChange = { isSwitchChecked = it },
                        modifier = Modifier.padding(end = dimensionResource(id = R.dimen.common_padding_min))
                    )
                }
            }
        }
    }
}