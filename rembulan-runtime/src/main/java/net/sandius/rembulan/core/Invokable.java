/*
 * Copyright 2016 Miroslav Janíček
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sandius.rembulan.core;

public interface Invokable {

	void invoke(ExecutionContext context) throws ControlThrowable;

	void invoke(ExecutionContext context, Object arg1) throws ControlThrowable;

	void invoke(ExecutionContext context, Object arg1, Object arg2) throws ControlThrowable;

	void invoke(ExecutionContext context, Object arg1, Object arg2, Object arg3) throws ControlThrowable;

	void invoke(ExecutionContext context, Object arg1, Object arg2, Object arg3, Object arg4) throws ControlThrowable;

	void invoke(ExecutionContext context, Object arg1, Object arg2, Object arg3, Object arg4, Object arg5) throws ControlThrowable;

	void invoke(ExecutionContext context, Object[] args) throws ControlThrowable;

}