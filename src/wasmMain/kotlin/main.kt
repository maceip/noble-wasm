import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.CanvasBasedWindow

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    var privKey = utils.randomPrivateKey();
    var pubKey = getPublicKey(privKey);
    var randn = etc.randomBytes(32);


    CanvasBasedWindow("Noble", canvasElementId = "canvas") {


        Box(modifier = Modifier.fillMaxSize()) {
            Text(randn.toString() + "kotlin wasm! ")
        }
    }
}


