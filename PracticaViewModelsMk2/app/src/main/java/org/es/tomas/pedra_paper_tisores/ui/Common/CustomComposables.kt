package org.es.tomas.pedra_paper_tisores.ui.Common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.es.tomas.pedra_paper_tisores.Model.Enums.Plays
import org.es.tomas.pedra_paper_tisores.Model.Player
import org.es.tomas.pedra_paper_tisores.ui.Screens.compareSelectedOptions
import org.es.tomas.pedra_paper_tisores.ui.ViewModels.GameScreenViewModel

@Composable
fun Botó (
    modifier: Modifier = Modifier,
    text: String = "",
    click: () -> Unit
) {
    OutlinedButton(
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 8.dp,
            disabledElevation = 0.dp
        ),
        onClick = click,
        shape = RoundedCornerShape(28.dp),
        modifier = modifier,
        contentPadding = PaddingValues(15.dp),
        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.secondary),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .align(alignment = Alignment.CenterVertically) )
        {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.onSecondary,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            )
        }

    }
}

@Composable
fun PlaySelector(
    viewModel: GameScreenViewModel,
    rival: Player,
    navController: NavController,
    textOption: Plays
) {
    Botó(
        text = textOption.toString(),
        click = {
            viewModel.decide(500L)
            compareSelectedOptions(
                rivalPlay = viewModel.state.result,
                yourPlay = textOption,
                rival = rival,
                navController = navController
            )
        }
    )
}