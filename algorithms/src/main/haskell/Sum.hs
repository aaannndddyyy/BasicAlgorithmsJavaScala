--
-- Testing
module Main where

-- Two examples with sum in Haskell

summation1 :: Integer -> Integer -> Integer
summation1 x y = summation' x y 0
summation' :: Integer -> Integer -> Integer -> Integer
summation' x y sum = if (y<x) then sum else summation' x (y-1) (sum+y)

sum2 :: [Integer] -> Integer -> Integer
sum2 xs y = foldl (+) 0 xs

main :: IO ()
main = print("Output : " ++ show(summation1 0 100) ++ " sum2= " ++ show(sum2 [0..100] 0))