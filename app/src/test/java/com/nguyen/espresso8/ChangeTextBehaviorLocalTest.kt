package com.nguyen.espresso8

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.intent.Intents
import androidx.test.ext.junit.runners.AndroidJUnit4

@RunWith(AndroidJUnit4::class)
class ChangeTextBehaviorLocalTest {
    /**
     * Use [ActivityScenarioRule] to create and launch the activity under test.
     */
    @get:Rule
    val intentsTestRule = IntentsTestRule(MyActivity::class.java)

    @Before
    fun intentsInit() {
        // initialize Espresso Intents capturing
        Intents.init()
    }

    @After
    fun intentsTeardown() {
        // release Espresso Intents capturing
        Intents.release()
    }

    @Test
    fun changeText_sameActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput))
            .perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard())
        onView(withId(R.id.changeTextBt)).perform(click())

        // Check that the text was changed.
        onView(withId(R.id.textToBeChanged)).check(matches(withText(STRING_TO_BE_TYPED)))
    }

    @Test
    fun changeText_newActivity() {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput)).perform(
            typeText(STRING_TO_BE_TYPED),
            closeSoftKeyboard()
        )
        onView(withId(R.id.activityChangeTextBtn)).perform(click())

        // An intent is fired to launch a different Activity. Robolectric doesn't currently
        // support launching a new Activity, so use Espresso Intents to verify intent was sent
        assertThat(Iterables.getOnlyElement(Intents.getIntents())).hasComponentClass(
            ShowTextActivity::class.java
        )
    }

    companion object {
        const val STRING_TO_BE_TYPED = "Espresso"
    }
}