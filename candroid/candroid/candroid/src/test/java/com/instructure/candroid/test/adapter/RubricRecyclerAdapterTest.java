/*
 * Copyright (C) 2016 - present  Instructure, Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, version 3 of the License.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.instructure.candroid.test.adapter;

import android.content.Context;
import android.test.InstrumentationTestCase;
import com.instructure.candroid.adapter.RubricRecyclerAdapter;
import com.instructure.canvasapi.model.RubricCriterionRating;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

@Config(sdk = 17)
@RunWith(RobolectricTestRunner.class)
public class RubricRecyclerAdapterTest extends InstrumentationTestCase {
    private RubricRecyclerAdapter mAdapter;

    /**
     * Make it so the protected constructor can be called
     */
    public static class RubricRecyclerAdapterWrapper extends RubricRecyclerAdapter {
        protected RubricRecyclerAdapterWrapper(Context context) {
            super(context);
        }
    }

    @Before
    public void setup(){
        mAdapter = new RubricRecyclerAdapterWrapper(RuntimeEnvironment.application.getApplicationContext());
    }

    @Test
    public void testAreContentsTheSame_SameNotComment(){
        RubricCriterionRating item = new RubricCriterionRating();
        item.setRatingDescription("item");

        assertTrue(mAdapter.createItemCallback().areContentsTheSame(item, item));
    }

    @Test
    public void testAreContentsTheSame_DifferentNotComment(){
        RubricCriterionRating item = new RubricCriterionRating();
        item.setRatingDescription("item");

        RubricCriterionRating item1 = new RubricCriterionRating();
        item1.setRatingDescription("item1");

        assertFalse(mAdapter.createItemCallback().areContentsTheSame(item, item1));
    }

    @Test
    public void testAreContentsTheSame_SameComment(){
        RubricCriterionRating item = new RubricCriterionRating();
        item.setRatingDescription("item");
        item.setComments("hodor");

        assertFalse(mAdapter.createItemCallback().areContentsTheSame(item, item));
    }
}
