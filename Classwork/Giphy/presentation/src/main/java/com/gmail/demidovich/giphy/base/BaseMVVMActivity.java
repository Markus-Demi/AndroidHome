package com.gmail.demidovich.giphy.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gmail.demidovich.giphy.BR;

public abstract class BaseMVVMActivity<Binding extends ViewDataBinding,
        ViewModel extends BaseViewModel> extends AppCompatActivity {

    protected ViewModel mViewModel;
    protected Binding mBinding;

    public abstract int provideLayoutId();

    public abstract ViewModel provideViewModel();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = provideViewModel();
        mBinding = DataBindingUtil.setContentView(this, provideLayoutId());
        mBinding.setVariable(BR.viewModel, mViewModel);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewModel.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mViewModel.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewModel.onStop();
    }
}