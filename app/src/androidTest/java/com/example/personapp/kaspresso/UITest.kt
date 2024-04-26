package com.example.personapp.kaspresso
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.personapp.kaspresso.screen.PersonInfoScreen
import com.example.personapp.kaspresso.screen.PersonListScreen
import com.example.personapp.presentation.activities.PersonListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class UITest : KTestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(PersonListActivity::class.java)


    //case-1
    //Не получилось реализовать тест как в условии
    //Реализовала тест, который проверяет, отобразились ли поля
    @Test
    fun testPersonListDisplayedCorrectly() {
        run {
            PersonListScreen {
                personListView {
                    childAt<PersonListScreen.PersonItem>(0) {
                        image {
                            isVisible()
                        }
                        name {
                            isVisible()
                        }
                        address {
                            isVisible()
                        }
                        mail {
                            isVisible()

                        }
                        phone {
                            isVisible()
                        }
                    }

                }
            }
        }
    }

    @Test //Case-2
    fun checkCardClickableAndItemInfoScreenClickable() = run {
        step("Check card is clickable and go to PersonInfoActivity") {
            PersonListScreen {
                checkClickableCard(Array(5) { 0 })
            }
        }
        step("Click on rv item") {
            PersonListScreen {
                personListView {
                    childAt<PersonListScreen.PersonItem>(0) {
                        click()
                    }
                }
            }
        }
        step("Check params person info is clickable ") {
            PersonInfoScreen {
                phone {
                    isClickable()
                }
                addressCity {
                    isClickable()
                }
                mail {
                    isClickable()
                }

                name {
                    isNotClickable()
                }
                addressStreet {
                    isNotClickable()
                }
                dob {
                    isNotClickable()
                }
                image {
                    isNotClickable()
                }
            }
        }
    }


    private fun checkClickableCard(array: Array<Any>) {
        array.forEachIndexed { index, personCard ->
            PersonListScreen {
                personListView {
                    childAt<PersonListScreen.PersonItem>(index) {
                        isClickable()
                    }
                }
            }
        }
    }

}