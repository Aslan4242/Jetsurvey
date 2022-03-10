package uiCompose

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.example.compose.jetsurvey.MainActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
class MyComposeTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()


    @Test
    fun CheckWelcomeScreenTest() {
        // Проверяем отображение полей на экране 'Sign in'
        composeTestRule.onNodeWithText("Email").assertIsDisplayed()
        composeTestRule.onNodeWithText("CONTINUE").assertIsDisplayed()
        composeTestRule.onNodeWithText("SIGN IN AS GUEST").assertIsDisplayed()
    }

    @Test
    fun CheckSignInScreenTest() {
        // Вводим email
        composeTestRule.onNodeWithText("Email").performTextReplacement("mymail@gmail.com")

        // Нажимаем 'CONTINUE'
        composeTestRule.onNodeWithText("CONTINUE").performClick()

        // Проверяем отображение полей на экране 'Sign in'
        composeTestRule.onNodeWithText("Email").assertIsDisplayed()
        composeTestRule.onNodeWithText("Password").assertIsDisplayed()
        composeTestRule.onNodeWithText("SIGN IN AS GUEST").assertIsDisplayed()
        composeTestRule.onNodeWithText("FORGOT PASSWORD?").assertIsDisplayed()
    }

    @Test
    fun CheckNextButtonIsDisplayedTest() {
        // Нажимаем на кнопку 'SIGN IN AS GUEST'
        composeTestRule.onNodeWithText("SIGN IN AS GUEST").performClick()

        // Проверяем отображение кнопки 'NEXT'
        composeTestRule.onNodeWithText("NEXT").assertIsDisplayed()
    }
}
















