package com.example.boredmirzhan.ui.notifications;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.viewpager2.widget.ViewPager2;

import com.example.boredmirzhan.Prefs;
import com.example.boredmirzhan.R;
import com.example.boredmirzhan.databinding.FragmentBoardBinding;


public class BoardFragment extends Fragment {
    FragmentBoardBinding binding;
    ViewPager2 viewPager2;
    NavController navController;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentBoardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        new Prefs(requireContext()).saveBoardState();

        binding.viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                changeColor();
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                changeColor();
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BoardAdapter adapter = new BoardAdapter();
        binding.viewPager2.setAdapter(adapter);

        requireActivity().getOnBackPressedDispatcher()
                .addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        requireActivity().fileList();
                    }
                });
    }
    @SuppressLint("ResourceAsColor")
    private void changeColor() {
        if(binding.viewPager2.getCurrentItem() == 0 ){

            binding.iv1.setImageResource(R.drawable.green_bg);
            binding.iv2.setImageResource(R.drawable.gray_bg);
            binding.iv3.setImageResource(R.drawable.gray_bg);
        }else {
            if(binding.viewPager2.getCurrentItem() == 1){

                binding.iv1.setImageResource(R.drawable.gray_bg);
                binding.iv2.setImageResource(R.drawable.green_bg);
                binding.iv3.setImageResource(R.drawable.gray_bg);
            }else{

                binding.iv1.setImageResource(R.drawable.gray_bg);
                binding.iv2.setImageResource(R.drawable.gray_bg);
                binding.iv3.setImageResource(R.drawable.green_bg);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}