################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
INO_SRCS += \
../lab_05.ino 

CPP_SRCS += \
../.ino.cpp \
../Enums.cpp 

LINK_OBJ += \
./.ino.cpp.o \
./Enums.cpp.o 

INO_DEPS += \
./lab_05.ino.d 

CPP_DEPS += \
./.ino.cpp.d \
./Enums.cpp.d 


# Each subdirectory must supply rules for building sources it contributes
.ino.cpp.o: ../.ino.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/tools/avr/bin/avr-g++" -c -g -Os -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10605 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR     -I"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/arduino/avr/cores/arduino" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/arduino/avr/variants/standard" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/libraries/LiquidCrystal" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/libraries/LiquidCrystal/src" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/arduino/avr/libraries/Wire" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/arduino/avr/libraries/Wire/utility" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<"  -o  "$@"   -Wall
	@echo 'Finished building: $<'
	@echo ' '

Enums.cpp.o: ../Enums.cpp
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/tools/avr/bin/avr-g++" -c -g -Os -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10605 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR     -I"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/arduino/avr/cores/arduino" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/arduino/avr/variants/standard" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/libraries/LiquidCrystal" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/libraries/LiquidCrystal/src" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/arduino/avr/libraries/Wire" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/arduino/avr/libraries/Wire/utility" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<"  -o  "$@"   -Wall
	@echo 'Finished building: $<'
	@echo ' '

lab_05.o: ../lab_05.ino
	@echo 'Building file: $<'
	@echo 'Starting C++ compile'
	"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/tools/avr/bin/avr-g++" -c -g -Os -fno-exceptions -ffunction-sections -fdata-sections -fno-threadsafe-statics -MMD -mmcu=atmega328p -DF_CPU=16000000L -DARDUINO=10605 -DARDUINO_AVR_UNO -DARDUINO_ARCH_AVR     -I"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/arduino/avr/cores/arduino" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/arduino/avr/variants/standard" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/libraries/LiquidCrystal" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/libraries/LiquidCrystal/src" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/arduino/avr/libraries/Wire" -I"/home/kristofer/Downloads/arduino-1.6.5-r5/hardware/arduino/avr/libraries/Wire/utility" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" -D__IN_ECLIPSE__=1 -x c++ "$<"  -o  "$@"   -Wall
	@echo 'Finished building: $<'
	@echo ' '


