package team.gdsc.shelper.activity.error

import io.github.jisungbin.erratum.ErratumExceptionActivity

class ErrorActivity : ErratumExceptionActivity() {

    /*private val systemUiController by lazy { SystemUiController(window) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actionBar?.hide()

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            CarrotStyleTheme {
                ProvideWindowInsets {
                    val containerColor = MaterialTheme.colorScheme.background

                    SideEffect {
                        systemUiController.setStatusBarColor(containerColor)
                        systemUiController.setNavigationBarColor(Color.Transparent)
                    }

                    Exception(containerColor)
                }
            }
        }
    }

    @Composable
    fun Exception(containerColor: Color) {
        val message: String
        val lottieRaw: Int
        when (intent.getStringExtra(IntentConstant.Error)) {
            IntentConstant.NoInternet -> {
                message = stringResource(R.string.activity_error_internet)
                lottieRaw = R.raw.no_internet
            }
            else -> {
                lottieRaw = R.raw.rabbit
                message = when (BuildConfig.DEBUG) {
                    true -> exceptionString!!
                    else -> stringResource(R.string.activity_error_exception)
                }
            }
        }
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(lottieRaw))

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(color = containerColor)
                .statusBarsPadding()
        ) {
            val (content, footer) = createRefs()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(content) {
                        top.linkTo(parent.top)
                        bottom.linkTo(footer.top)
                        height = Dimension.fillToConstraints
                    },
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.activity_error_oops),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    modifier = Modifier.padding(horizontal = 30.dp),
                    text = message,
                    textAlign = TextAlign.Center
                )
                Button(onClick = { openLastActivity() }) {
                    Text(text = stringResource(R.string.activity_error_btn_retry))
                }
            }

            LottieAnimation(
                modifier = Modifier
                    .fillMaxWidth()
                    .constrainAs(footer) {
                        height = Dimension.value(300.dp)
                        bottom.linkTo(parent.bottom)
                    },
                iterations = LottieConstants.IterateForever,
                composition = composition,
            )
        }
    }*/
}
