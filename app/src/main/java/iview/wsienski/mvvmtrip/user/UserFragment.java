package iview.wsienski.mvvmtrip.user;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import iview.wsienski.mvvmtrip.MyApplication;
import iview.wsienski.mvvmtrip.R;
import iview.wsienski.mvvmtrip.databinding.UserFragmentBinding;

/**
 * Created by Witold Sienski on 10.12.2017.
 */

public class UserFragment extends Fragment {

    @Inject
    UserViewModel mViewModel;

    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment newInstance() {
        return new UserFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        ((MyApplication) getActivity().getApplication())
                .getAppComponent()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UserFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.user_fragment, container, false);

        binding.setViewModel(mViewModel);

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mViewModel.unBind();
    }
}
