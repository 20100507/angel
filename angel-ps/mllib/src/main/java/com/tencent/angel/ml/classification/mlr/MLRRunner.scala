/*
 * Tencent is pleased to support the open source community by making Angel available.
 *
 * Copyright (C) 2017 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package com.tencent.angel.ml.classification.mlr

import com.tencent.angel.ml.MLRunner
import org.apache.commons.logging.LogFactory
import org.apache.hadoop.conf.Configuration

/**
  * Created by hbghh on 2017/8/17.
  */
class MLRRunner extends MLRunner {
  private val LOG = LogFactory.getLog(classOf[MLRRunner])

  /**
    * Run MLR train task
    *
    * @param conf : configuration of algorithm and resource
    */
  override
  def train(conf: Configuration): Unit = {
    train(conf, MLRModel(conf), classOf[MLRTrainTask])
  }

  /*
   * Run MLR predict task
   * @param conf: configuration of algorithm and resource
   */
  override
  def predict(conf: Configuration): Unit = {
    super.predict(conf, MLRModel(conf), classOf[MLRPredictTask])
  }

  /*
   * Run MLR incremental train task
   * @param conf: configuration of algorithm and resource
   */
  def incTrain(conf: Configuration): Unit = {
    super.train(conf, MLRModel(conf), classOf[MLRTrainTask])
  }
}

