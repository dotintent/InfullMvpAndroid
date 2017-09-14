package com.infullmobile.android.infullmvp.sample.activity;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.infullmobile.android.infullmvp.basetest.InFullMvpActivityBaseTest;
import com.infullmobile.android.infullmvp.sample.activity.di.SampleActivityModule;
import com.infullmobile.android.infullmvp.sample.activity.di.SampleActivityScope;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import dagger.Provides;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

@RunWith(RobolectricTestRunner.class)
public class SampleActivityTest extends InFullMvpActivityBaseTest<
        SampleActivity, SampleActivityPresenter, SampleActivityView> {

    private FragmentStatePagerAdapter mockFragmentStatePagerAdapter = mock(FragmentStatePagerAdapter.class);

    @NonNull
    @Override
    protected Class<SampleActivity> getTestActivityClass() {
        return SampleActivity.class;
    }

    @Override
    public void substituteModules(@NonNull final SampleActivity activity) {
        super.substituteModules(activity);
        activity.sampleActivityGraph.setAddNewItemModule(new TestSampleActivityModule(activity));
    }

    @Test
    public void shouldSetAdapterOnViewsBound() {
        assertThat(getTestedView().getPager().getAdapter())
                .isEqualTo(mockFragmentStatePagerAdapter);
    }

    private final class TestSampleActivityModule extends SampleActivityModule {

        public TestSampleActivityModule(final SampleActivity sampleActivity) {
            super(sampleActivity);
        }

        @Override
        @Provides
        @SampleActivityScope
        protected FragmentStatePagerAdapter providesPagerAdapter(FragmentManager fragmentManager) {
            return mockFragmentStatePagerAdapter;
        }
    }
}
