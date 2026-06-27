package steps;

import Homework_4.Deque;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.function.ThrowingRunnable;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;


public class StepDefinitions {
    private Deque<Integer> myDeque;

    @Given("that I have a brand new deque")
    public void that_i_have_a_brand_new_deque() {
        myDeque = new Deque<Integer>();
    }

    @Given("that I have a deque with size {int}")
    public void that_i_have_a_deque_with_size(int size) {
        myDeque = new Deque<Integer>();
        for (int i = 0; i < size; i++) {
            myDeque.addBack(i + 1);
        }
    }

    @And("the second item has a value of {int}")
    public void the_second_item_has_a_value_of(int value) {
        final int[] index = {1};
        AtomicInteger secondValue = new AtomicInteger();
        AtomicBoolean isSecond = new AtomicBoolean(false);
        myDeque.iterator().forEachRemaining(item -> {
            if (index[0] == 2) {
                secondValue.set(item);
                isSecond.set(true);
            }
            index[0]++;
        });
        assertEquals(value, secondValue.get());
        assertTrue(isSecond.get());
    }

    @And("the second to last item has a value of {int}")
    public void the_second_to_last_item_has_a_value_of(int value) {
        final int[] index = {1};
        AtomicBoolean isSecondToLast = new AtomicBoolean(false);
        myDeque.iterator().forEachRemaining(item -> {
            if (index[0] == myDeque.size() - 1) {
                isSecondToLast.set(true);
            }
            index[0]++;
        });
        assertTrue(isSecondToLast.get());
    }

    @When("I ask the size of the deque")
    public void i_ask_the_size_of_the_deque() {
        myDeque.size();
    }

    @When("I add an item, {int}, to the {string} of the deque")
    public void i_add_an_item_to_the_deque(int item, String position) {
        if (position.equalsIgnoreCase("front")) {
            myDeque.addFront(item);
        } else {
            myDeque.addBack(item);
        }
    }

    @When("I remove the first item")
    public void i_remove_the_first_item() {
        myDeque.removeFront();
    }

    @When("remove the last item")
    public void remove_the_last_item() {
        myDeque.removeBack();
    }

    @When("I remove the second item")
    public void remove_the_second_item() {
        myDeque.removeSecond();
    }

    @Then("it should tell me size is {int}")
    public void it_should_tell_me_size_is(int size) {
        assertEquals(size, myDeque.size());
    }

    @Then("the value of the {string} item is now {int}")
    public void it_should_tell_me_value_is(String position, int value) {
        if (position.equalsIgnoreCase("front")) {
            int first = myDeque.getFront();
            assertEquals(first, value);
        } else {
            int last = myDeque.getBack();
            assertEquals(last, value);
        }
    }

    @Then("the value of the item at the {string} should be {int}")
    public void the_value_of_the_item_at_the_should_be_(String position, int value) {
        if (position.equalsIgnoreCase("front")) {
            int item = myDeque.getFront();
            assertEquals(value, item);
        } else {
            int item = myDeque.getBack();
            assertEquals(value, item);
        }
    }

    @Then("a NoSuchElementException is thrown")
    public void a_NoSuchElementException_is_thrown() {
        assertThrows(NoSuchElementException.class, () -> myDeque.removeSecond());
    }
}
