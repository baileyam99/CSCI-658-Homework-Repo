package stepsAi;

import Homework_4.DequeAi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DequeStepDefinitionsAi {
    private DequeAi<String> deque;
    private String removedItem;
    private RuntimeException removeSecondException;

    @Given("a new deque")
    public void aNewDeque() {
        deque = new DequeAi<>();
    }

    @When("I add {string} to the front")
    public void iAddToTheFront(String item) {
        deque.addFront(item);
    }

    @When("I add {string} to the back")
    public void iAddToTheBack(String item) {
        deque.addBack(item);
    }

    @When("I remove an item from the front")
    public void iRemoveAnItemFromTheFront() {
        removedItem = deque.removeFront();
    }

    @When("I remove an item from the back")
    public void iRemoveAnItemFromTheBack() {
        removedItem = deque.removeBack();
    }

    @When("I remove the second item from the front")
    public void iRemoveTheSecondItemFromTheFront() {
        removedItem = deque.removeSecond();
    }

    @When("I attempt to remove the second item from the front")
    public void iAttemptToRemoveTheSecondItemFromTheFront() {
        try {
            deque.removeSecond();
        } catch (RuntimeException exception) {
            removeSecondException = exception;
        }
    }

    @Then("the deque is empty")
    public void theDequeIsEmpty() {
        assertTrue(deque.empty());
    }

    @Then("the deque is not empty")
    public void theDequeIsNotEmpty() {
        assertFalse(deque.empty());
    }

    @Then("the deque size is {int}")
    public void theDequeSizeIs(int expectedSize) {
        assertEquals(expectedSize, deque.size());
    }

    @Then("the deque contains {string} from front to back")
    public void theDequeContainsFromFrontToBack(String expectedItems) {
        List<String> actualItems = new ArrayList<>();
        for (String item : deque) {
            actualItems.add(item);
        }

        assertEquals(expectedItems, String.join(", ", actualItems));
    }

    @Then("the removed item is {string}")
    public void theRemovedItemIs(String expectedItem) {
        assertEquals(expectedItem, removedItem);
    }

    @Then("removing the second item fails because fewer than two items exist")
    public void removingTheSecondItemFailsBecauseFewerThanTwoItemsExist() {
        assertTrue(removeSecondException instanceof NoSuchElementException);
    }
}
