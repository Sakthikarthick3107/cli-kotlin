import {StyleSheet, Text, View, NativeModules, Button} from 'react-native';
import React from 'react';
const ToastService = NativeModules.ToastModule;
const BatteryModule = NativeModules.BatteryModule;

const App = () => {
  async function getBatteryLevel() {
    try {
      const level = await BatteryModule.getBatteryLevel();
      console.log(level);
      ToastService.showToast((level * 100).toString());
    } catch (error) {
      console.error(error);
    }
  }
  return (
    <View style={styles.container}>
      <Text style={styles.text}>App</Text>
      <Button
        onPress={() => ToastService.showToast('Your Toast Message')}
        title="Toast Button"
      />
      <Button onPress={getBatteryLevel} title="GEt battery level" />
    </View>
  );
};

export default App;

const styles = StyleSheet.create({
  container: {
    display: 'flex',
    flexGrow: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  text: {
    fontSize: 30,
  },
});
